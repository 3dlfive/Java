package homework4;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    protected Family(Human mother,Human father,Human[] children,Pet pet){
        this.mother=mother;
        this.father=father;
        this.children=children;
        this.pet=pet;
    }
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    public Pet getPet() {
        return pet;
    }
    public static FamilyBuilder builder(){
        return new FamilyBuilder();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }
    public void addChild(Human child){

        child.setFamily(Family.builder().withMother(new Human(this.getMother().getName(),this.getMother().getSurname() ,1998)).withFather(new Human(this.getFather().getName(),this.getFather().getSurname(), 1992))
                .build());
        Human[] childrenTempArr ;
        childrenTempArr =Arrays.copyOf(children,children.length+1);
        childrenTempArr[childrenTempArr.length-1]= child;
        this.children = childrenTempArr;
    }
    public static class FamilyBuilder {
        private Human mother;
        private Human father;
        private Human[] children = new Human[]{};

        private Pet pet;
        public FamilyBuilder withMother(Human mother){
            this.mother=mother;
            return this;
        }
        public FamilyBuilder withFather(Human father){
            this.father=father;
            return this;
        }
        public FamilyBuilder withChildren(Human[] children){
            this.children=children;
            return this;

        }
        public FamilyBuilder withPet(Pet pet){
            this.pet=pet;
            return this;
        }
        public Family build(){
            if (mother==null || father==null){
                throw new IllegalStateException("We need mother and father ! ");
            } else {
                return new Family(mother,father,children,pet);
            }

        }
    }
}
class FamilyTest{
    public static void main(String[] args) {
        Family f1 = Family.builder().withMother(new Human("Oksana","Pertovna",1991)).withFather(new Human("Oleg","Kopchik",1992))
                .build();
        System.out.println(f1.toString());
        f1.addChild(new  Human("Nina","Petro",2020));
        Human ch1 = f1.getChildren()[0];
        System.out.println(ch1.getFamily());
    }
}
