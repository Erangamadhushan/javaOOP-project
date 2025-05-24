package com.bluelanka_guide.models;

import com.bluelanka_guide.views.ViewFactoryTravelTools;

public class Model {
    private final ViewFactoryTravelTools viewFactoryTravelTools;
    private static Model model;

    private Model(){
        this.viewFactoryTravelTools = new ViewFactoryTravelTools();
    }

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactoryTravelTools getViewFactoryTravelTools(){
        return viewFactoryTravelTools;
    }
}
