package org.xmlcml.euclid.util;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.xml.XMLUtil;

import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets;

import nu.xom.Node;

/** mainly static tools.
 * 
 * @author pm286
 *
 */
public class MultisetUtil {

	/** sort entrySet by count.
	 * convenience method.
	 * @param wordSet
	 * @return
	 */
	public static Iterable<Multiset.Entry<String>> getEntriesSortedByCount(Multiset<String> wordSet) {
		return Multisets.copyHighestCountFirst(wordSet).entrySet();
	}

	public static Iterable<Entry<String>> getEntriesSortedByValue(Multiset<String> wordSet) {
		return  ImmutableSortedMultiset.copyOf(wordSet).entrySet();
	}

	
	public static Iterable<Entry<Integer>> getIntegerEntriesSortedByValue(Multiset<Integer> integerSet) {
		return  ImmutableSortedMultiset.copyOf(integerSet).entrySet();		
	}
	
	public static Iterable<Multiset.Entry<Integer>> getIntegerEntriesSortedByCount(Multiset<Integer> integerSet) {
		return Multisets.copyHighestCountFirst(integerSet).entrySet();
	}


	public static Iterable<Entry<Double>> getDoubleEntriesSortedByValue(Multiset<Double> doubleSet) {
		return  ImmutableSortedMultiset.copyOf(doubleSet).entrySet();		
	}
	
	public static Iterable<Multiset.Entry<Double>> getDoubleEntriesSortedByCount(Multiset<Double> doubleSet) {
		return Multisets.copyHighestCountFirst(doubleSet).entrySet();
	}




	/** extracts a list of attribute values.
	 * 
	 * @return
	 */
	public static List<String> getAttributeValues(Node searchNode, String xpath) {
		List<Node> nodes = XMLUtil.getQueryNodes(searchNode, xpath);
		List<String> nodeValues = new ArrayList<String>();
		for (Node node : nodes) {
			String value = node.getValue();
			if (value != null && value.trim().length() != 0) {
				nodeValues.add(value);
			}
		}
		return nodeValues;
	}

	public static Double getLowestValue(Multiset<Double> valueSet) {
		Iterable<Multiset.Entry<Double>> values = MultisetUtil.getDoubleEntriesSortedByValue(valueSet);
		Multiset.Entry<Double> entries = values.iterator().hasNext() ? (Multiset.Entry<Double>) values.iterator().next() : null;
		Double value = (entries == null) ? null : entries.getElement();
		return value;
	}

	public static Double getHighestValue(Multiset<Double> valueSet) {
		Iterable<Multiset.Entry<Double>> values = MultisetUtil.getDoubleEntriesSortedByValue(valueSet);
		List<Entry<Double>> entries = createDoubleEntryList(values);
		return entries.size() == 0 ? null : entries.get(entries.size() - 1).getElement();
	}

	public static Double getCommonestValue(Multiset<Double> valueSet) {
		Iterable<Multiset.Entry<Double>> values = MultisetUtil.getDoubleEntriesSortedByCount(valueSet);
		Multiset.Entry<Double> entries = values.iterator().hasNext() ? (Multiset.Entry<Double>) values.iterator().next() : null;
		Double value = (entries == null) ? null : entries.getElement();
		return value;
	}

	public static List<Entry<String>> createStringEntryList(Iterable<Entry<String>> iterable) {
		List<Entry<String>> entries = new ArrayList<Entry<String>>();
		for (Entry<String> entry : iterable) {
			entries.add(entry);
		}
		return entries;
	}
	
	public static List<Entry<Double>> createDoubleEntryList(Iterable<Entry<Double>> iterable) {
		List<Entry<Double>> entries = new ArrayList<Entry<Double>>();
		for (Entry<Double> entry : iterable) {
			entries.add(entry);
		}
		return entries;
	}
}
