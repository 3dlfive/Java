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

        child.setFamily(Family.builder().withMother(new Human(this.getMother().getName(),this.getMother().getSurname() ,1998)).withFather(new Human(this.getFather().getName(),this.getFather().getSurname(), 1992))
                .build());
        Human[] childrenTempArr ;
        childrenTempArr =Arrays.copyOf(children,children.length+1);
        childrenTempArr[childrenTempArr.length-1]= child;
        this.children = childrenTempArr;
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
            System.out.println(Arrays.toString(childArr1));
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

    public static class FamilyBuilder {
        private Human mother;
        private Human father;
        private Human[] children = new Human[]{};

        private Pet pet;
        public FamilyBuilder withMother(Human mother){
//            mother.setFamily(this);// Как присвоить ту же семью
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
        f1.addChild(new  Human("Nina2","Petro2",2021));
        f1.addChild(new  Human("Nina3","Petro3",2021));

        System.out.println(f1.getChildren().length);
        f1.deleteChild(0);
        System.out.println(f1.getChildren().length);
    }
}
