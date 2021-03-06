package org.joinfaces.richfaces.example.model;

import com.google.common.collect.Iterators;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Country extends NamedNode implements TreeNode {

    private List<Company> companies = new ArrayList<Company>();

    public Country() {
        this.setType("country");
    }

    public TreeNode getChildAt(int childIndex) {
        return companies.get(childIndex);
    }

    public int getChildCount() {
        return companies.size();
    }

    public TreeNode getParent() {
        return null;
    }

    public int getIndex(TreeNode node) {
        return companies.indexOf(node);
    }

    public boolean getAllowsChildren() {
        return true;
    }

    public boolean isLeaf() {
        return companies.isEmpty();
    }

    public Enumeration<Company> children() {
        return Iterators.asEnumeration(companies.iterator());
    }

    public List<Company> getCompanies() {
        return companies;
    }

}
