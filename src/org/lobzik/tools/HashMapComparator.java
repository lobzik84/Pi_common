package org.lobzik.tools;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

public class HashMapComparator implements Comparator<HashMap>, Serializable {
	private static final long serialVersionUID = 1L;
	String sortFieldName;
	int growth;

	public HashMapComparator(String sortFieldName, boolean ascending) {
		this.sortFieldName = sortFieldName;
		this.growth = ascending ? 1 : -1;
	}

	public int compare(HashMap o1, HashMap o2) {
		Comparable comp1 = (Comparable) o1.get(this.sortFieldName);
		Comparable comp2 = (Comparable) o2.get(this.sortFieldName);
		if ((comp1 == null) && (comp2 == null)) {
			return 0;
		} else if (comp1 == null) {
			return (-1) * this.growth;
		} else if (comp2 == null) {
			return 1 * this.growth;
		}
		return comp1.compareTo(comp2) * this.growth;
	}
}
