package com.github.attilagyongyosi.vsw.ui.components;

import com.github.attilagyongyosi.vsw.ui.views.MainView;
import com.github.attilagyongyosi.vsw.users.UserEntity;
import com.github.attilagyongyosi.vsw.users.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UIScope
@Component
public class RegistrationForm extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    private UserEntity user = new UserEntity();

    private Binder<UserEntity> binder = new Binder();

    private FormLayout form = new FormLayout();
    private TextField nameField = new TextField();
    private TextField userNameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Register");

    private Dialog successDialog = new Dialog();

    public RegistrationForm() {
        this.initializeLayout();
        this.initializeHandlers();
    }

    private void initializeLayout() {
        this.setupForm();
        this.setupDialog();
    }

    private void setupForm() {
        this.form.addFormItem(this.nameField, "Name");
        this.form.addFormItem(this.userNameField, "Username");
        this.form.addFormItem(this.passwordField, "Password");
        add(this.form);
        add(this.loginButton);

        setHorizontalComponentAlignment(Alignment.CENTER, this.form);
        setHorizontalComponentAlignment(Alignment.CENTER, this.loginButton);
        this.binder.bind(this.nameField, UserEntity::getName, UserEntity::setName);
    }

    private void setupDialog() {
        this.successDialog.setCloseOnEsc(false);
        this.successDialog.setCloseOnOutsideClick(false);

        Label messageLabel = new Label("Registration Successful");
        Button confirmButton = new Button("Confirm", event -> UI.getCurrent().navigate(MainView.class));
        successDialog.add(messageLabel);
        successDialog.add(confirmButton);
        add(this.successDialog);
    }

    private void initializeHandlers() {
        this.loginButton.addClickListener(clickEvent -> {
            this.userRepository.save(this.user);
            this.successDialog.open();
        });
    }
}
