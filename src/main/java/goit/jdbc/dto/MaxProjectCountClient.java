package goit.jdbc.dto;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
