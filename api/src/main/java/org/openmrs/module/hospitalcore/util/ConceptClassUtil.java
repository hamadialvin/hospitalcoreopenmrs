/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */


package org.openmrs.module.hospitalcore.util;

import org.openmrs.ConceptClass;
import org.openmrs.api.context.Context;

public class ConceptClassUtil {
	private static ConceptClass medicalExaminationClass = null;
	
	/**
	 * Get concept class of medical examination class
	 * @return ConceptClass
	 */
	public static ConceptClass getMedicalExamminationClass(){
		return getConceptClass(medicalExaminationClass, HospitalCoreConstants.PROPERTY_MEDICAL_EXAMINATION);
	}
	
	private static ConceptClass getConceptClass(ConceptClass conceptClass, String keyname){
		if(conceptClass==null){
			String idStr = Context.getAdministrationService().getGlobalProperty(keyname);
			try {
				Integer id = Integer.parseInt(idStr);
				conceptClass = Context.getConceptService().getConceptClass(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conceptClass;
	}
}
