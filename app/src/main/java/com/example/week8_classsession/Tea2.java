package com.example.week8_classsession;

public class Tea2 {
    public static void main(String[] args) {
        Tea2.TeaBuilder teaBuilder = new Tea2.TeaBuilder();
        teaBuilder.setSugar(false).setMilk(false);
        Tea2 tea = teaBuilder.build();
        System.out.println(tea.sugar);
        System.out.println(tea.milk);

    }
    private boolean sugar;
    private boolean milk;
    private Tea2(TeaBuilder teaBuilder){
        this.sugar = teaBuilder.sugar;
        this.milk = teaBuilder.milk;
    }

    static class TeaBuilder {
        private boolean sugar;
        private boolean milk;

        TeaBuilder(){}

        public TeaBuilder setSugar ( boolean sugar){
            this .sugar = sugar;
            return this; }

        public TeaBuilder setMilk ( boolean milk){
            this .milk = milk;
            return this; }

        public Tea2 build (){
            return new Tea2( this ); }
    }
}

