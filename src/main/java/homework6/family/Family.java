package homework6.family;

import homework6.human.Human;
import homework6.pet.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
//    static {
//        System.out.println("New class Family loaded");
//    }
//    {
//        System.out.println("New Family object created.");
//    }

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
    public int countFamily(){
        return 2+ children.length;
    }
    public Pet getPet() {
        return pet;
    }
    public static FamilyBuilder builder(){
        return new FamilyBuilder();
    }


    public void addChild(Human child){
//        System.out.println("------THIS"+this);
        child.setFamily(this);
        Human[] childrenTempArr ;
        childrenTempArr =Arrays.copyOf(children,children.length+1);
        childrenTempArr[childrenTempArr.length-1]= child;
        this.children = childrenTempArr;
    }
    public boolean deleteChild(Human child){
        boolean ifIteminList = false;
        int indexOfchildtoDelete = 0;
        for (int i=0;i<children.length;i++)
            if (children[i].equals(child)) {
                ifIteminList=true;
                indexOfchildtoDelete = i;
            }

        if (ifIteminList) this.deleteChild(indexOfchildtoDelete);
        return ifIteminList;
    }
    public boolean deleteChild(int indexOfChild){
        if ((indexOfChild>=0 && indexOfChild<=this.children.length)){
            Human[] childArr1=new Human[this.children.length-1];
            for(int index=0;index<this.children.length-1;index++){
                if (index >= indexOfChild ){
                    childArr1[index]=this.children[index+1];
                } else {
                    childArr1[index]=this.children[index];
                }
            }
            this.children=childArr1;
//            System.out.println(Arrays.toString(childArr1));
//            if(this.children.length>=3){
//                Human[] childArr1 = Arrays.copyOfRange(children,0,indexOfChild-1);
//                Human[] childArr2 = Arrays.copyOfRange(children,indexOfChild+1,children.length);
//                this.children=concatTwoArray(childArr1,childArr2);
//            }

            return true;
        } else {
            return false;
        }
    }
    public Human[] concatTwoArray(Human[] arr1,Human[] arr2){
        //Method to concat two Human arrays
        Human[] result = new Human[arr1.length+arr2.length];
        int position = 0;
        for (Human el:arr1){
            result[position]=el;
            position++;
        } for (Human el:arr2){
            result[position]=el;
            position++;
        }
        return result;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(getMother(), family.getMother()) && Objects.equals(getFather(), family.getFather());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather());
    }
    @Override
    public void finalize(){
        System.out.println("Обєкт прибраний" +this.toString());
    }
    public static class FamilyBuilder {
        private Human mother;
        private Human father;
        private Human[] children = new Human[]{};

        private Pet pet;
        public FamilyBuilder withMother(Human mother){
//            mother.setFamily(this);//Не работает Как присвоить ту же семью
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

