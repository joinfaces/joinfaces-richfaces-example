package org.joinfaces.richfaces.example.beans;

import org.joinfaces.richfaces.example.model.Framework;
import org.richfaces.event.DropEvent;
import org.richfaces.event.DropListener;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DragDropEventBean implements DropListener {

    @Inject
    private DragDropBean dragDropBean;

    public void setDragDropBean(DragDropBean dragDropBean) {
        this.dragDropBean = dragDropBean;
    }

    public void processDrop(DropEvent event) {
        dragDropBean.moveFramework((Framework) event.getDragValue());
    }
}