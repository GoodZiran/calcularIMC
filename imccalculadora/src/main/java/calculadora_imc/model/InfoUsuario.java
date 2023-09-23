package calculadora_imc.model;

public class InfoUsuario {

    public String calculoIMC(double peso, double altura) {

        double imc = peso / (altura * altura);

        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else if (imc < 34.9) {
            return "Obesidade grau I";
        } else if (imc < 39.9) {
            return "Obesidade grau II";
        } else if (imc > 40) {
            return "Obesidade grau III";
        } else {
            return "Não foi possível calcular";
        }

    }

}