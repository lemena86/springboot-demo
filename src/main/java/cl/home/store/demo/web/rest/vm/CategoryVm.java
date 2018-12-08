package cl.home.store.demo.web.rest.vm;

public class CategoryVm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryVm{" +
                "name='" + name + '\'' +
                '}';
    }
}
