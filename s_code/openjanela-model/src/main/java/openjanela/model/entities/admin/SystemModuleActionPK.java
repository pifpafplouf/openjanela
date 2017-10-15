package openjanela.model.entities.admin;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 03-26-14
 *          Time Initial: 06:39 PM
 */
@Embeddable
public class SystemModuleActionPK implements Serializable {

	@Column(name = "actionid")
    private int actionId;

	@Column(name = "module")
    private int module;

	public SystemModuleActionPK() {
	}

	public SystemModuleActionPK(int actionId, int module) {
		super();
		this.actionId = actionId;
		this.module = module;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public int getModule() {
		return module;
	}

	public void setModule(int module) {
		this.module = module;
	}

}

