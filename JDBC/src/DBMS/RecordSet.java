package DBMS;

import java.util.HashSet;

@SuppressWarnings("serial")
public class RecordSet extends HashSet<Record>{		//changed from hashset to vector

	private String[] attributesNames;

	public RecordSet(String[] attributes) {
		attributesNames = attributes;
	}

	public String[] getAttributesNames() {
		return attributesNames;
	}

	public void setAttributesNames(String[] attributesNames) {
		this.attributesNames = attributesNames;
	}
	
	public String getAttributeName(int columnInd) {
		if(columnInd>-1 && columnInd<attributesNames.length)
			return attributesNames[columnInd];
		return null;
	}
	
	public int getAttributeIndex(String columnName) {
		for(int i=0; i<attributesNames.length; i++){
			if(attributesNames[i].equalsIgnoreCase(columnName))
				return i;
		}
		return -1;
	}
}