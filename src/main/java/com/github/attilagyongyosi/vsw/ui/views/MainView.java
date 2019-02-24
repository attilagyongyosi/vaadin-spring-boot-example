package com.github.attilagyongyosi.vsw.ui.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route
public class MainView extends VerticalLayout {
    private Anchor registrationAnchor = new Anchor("/registration", "Create an account");

    @PostConstruct
    public void init() {
        add(this.registrationAnchor);
    }
}
