package org.joinfaces.richfaces.example.beans;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.richfaces.event.ItemChangeEvent;

import java.io.Serializable;

@Named
@ConversationScoped
public class PanelMenuBean implements Serializable {
	private String current;
	private boolean singleMode;

	public boolean isSingleMode() {
		return singleMode;
	}

	public void setSingleMode(boolean singleMode) {
		this.singleMode = singleMode;
	}

	public String getCurrent() {
		return this.current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public void updateCurrent(ItemChangeEvent event) {
		setCurrent(event.getNewItemName());
	}
}