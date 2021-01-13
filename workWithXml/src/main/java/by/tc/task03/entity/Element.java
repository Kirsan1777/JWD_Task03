package by.tc.task03.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Element {
    private String mainElementName;
    private List<Subject> listWithSubject = new ArrayList<>();

    public String getMainElementName() {
        return mainElementName;
    }

    public void setMainElementName(String mainElementName) {
        this.mainElementName = mainElementName;
    }

    public List<Subject> getListWithSubject() {
        return listWithSubject;
    }

    public void setListWithSubject(List<Subject> listWithAttribute) {
        this.listWithSubject = listWithAttribute;
    }

    @Override
    public String toString() {
        return mainElementName + " " + listWithSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return Objects.equals(mainElementName, element.mainElementName) &&
                Objects.equals(listWithSubject, element.listWithSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainElementName, listWithSubject);
    }
}
