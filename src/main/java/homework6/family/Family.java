package homework6.family;

import homework6.human.Human;
import homework6.human.Men;
import homework6.human.Women;
import homework6.pet.Pet;

import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
//    private Human[] children;
    private ArrayList<Human> children = new ArrayList<>();
    private Pet pet;
    private Set<Pet> pets = new HashSet<>();
//    static {
//        System.out.println("New class Family loaded");
//    }
//    {
//        System.out.println("New Family object created.");
//    }

    protected Family(Human mother,Human father,ArrayList<Human> childrens,Pet pet){
        this.mother=mother;
        this.father=father;
        this.children.addAll(childrens);
        this.pets.add(pet);
        this.pet=pet;
    }
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public ArrayList<Human> getChildren() {

        return children;
    }
    public int countFamily(){
        return 2+ children.size();
    }
    public Set<Pet> getPet() {
        return pets;
    }
    public static FamilyBuilder builder(){
        return new FamilyBuilder();
    }


    public void addChild(Human child){
//        System.out.println("------THIS"+this);

        this.children.add(child);

    }
    //    Реализуйте интерфейс HumanCreatorв одном из существующих классов проекта. Реализация должна возвращать новый объект Man или Woman, с установленными ссылками на текущую семью, фамилией отца, случайным именем (требуется заранее создать список имен) и средним IQ (от отца и матери). Пол ребенка определяется случайно с вероятностью 50х50.
    public Human bornChild(){
        String[] childNamesMen = new String[]{"Denys","Anton","Oleg","Alex"};
        String[] childNamesWomen = new String[]{"Alla","Aura","Gabriella","Gigi"};
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        int randomChildrenName = random.nextInt(childNamesMen.length);
        int childIq = (this.getMother().getIq()+this.getFather().getIq())/2;
        if(randomNumber==0){
            Women childGirl = new Women(childNamesWomen[randomChildrenName],this.getFather().getSurname(),"20/03/2016",childIq,this);
            this.addChild(childGirl);
            return childGirl;
        }else{
            Men childBoy = new Men(childNamesMen[randomChildrenName],this.getFather().getSurname(),"20/03/2016",childIq,this);
            this.addChild(childBoy);
            return childBoy;
        }


    }

    public boolean deleteChild(Human child) {
        return children.remove(child);
    }
    public boolean deleteChild(int indexOfChild){
        if ((indexOfChild>=0 && indexOfChild<=this.children.size())){

            this.children.remove(indexOfChild);


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
                ", children=" + children +
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
    public String prettyFormat(){
        String header = "family: ";
        String mother ="\n\tmother: "+this.getMother().prettyFormat()+",";
        String father ="\n\tfather: "+this.getFather().prettyFormat()+",";
        String header2 = "\n\tchildren: ";
        StringBuilder child = new StringBuilder();
        this.getChildren().stream().forEach(el->{
            StringBuilder stringBuilder = new StringBuilder((el instanceof Men) ? "\n\t\tboy:" + el.prettyFormat() : "\n\t\tgirl:" + el.prettyFormat());
            child.append(stringBuilder);
        });
        StringBuilder mpets = new StringBuilder("[");
        this.getPet().stream().forEach(el->{
            if(el!=null) {
                mpets.append(el.prettyFormat());
//                System.out.println(el.prettyFormat());
            }
        });
        mpets.append("]");
        return header+mother+father+header2+child+"\n\tpets:"+mpets;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather());
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public static class FamilyBuilder {
        private Human mother;
        private Human father;
        private ArrayList<Human> children = new ArrayList<>();

        private Pet pet;
        private Set<Pet> pets = new HashSet<>();
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
            this.children.addAll(Arrays.asList(children));
            return this;

        }
        public FamilyBuilder withPet(Pet pet){
            this.pets.add(pet);
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

