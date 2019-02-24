package com.github.attilagyongyosi.vsw.ui.views;

import com.github.attilagyongyosi.vsw.ui.components.RegistrationForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route("registration")
public class RegistrationView extends VerticalLayout {

    @Autowired
    private RegistrationForm registrationForm;

    @PostConstruct
    public void init() {
        this.initializeView();
    }

    private void initializeView() {
        add(this.registrationForm);
        setSizeFull();
    }
}
