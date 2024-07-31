package iftm.edu.br.funcionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTests {
    private Funcionario funcionario;

    @BeforeEach
    public void instanciarObjetos() {
        funcionario = new Funcionario();
    }

    // Ana
    //Casos de teste para validar a quantidade de horas trabalhadas
    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é válido e não está no limite máximo de 40 horas")
    public void TestarHorasTrabalhadasValidasForaDoLimite() {
        //Arrange
        int horasTrabalhadasValidas = 35;
        Double valorHoraValido = 65.00;
        int horasTrabalhadasEsperada = 35;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        int horasTrabalhadasObtida = funcionario.getHorasTrabalhadas();

        //Assert
        assertEquals(horasTrabalhadasEsperada, horasTrabalhadasObtida);
    }

    // Ana
    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é válido e está no limite máximo de 40 horas")
    public void TestarHorasTrabalhadasValidasNoLimite() {
        //Arrange
        int horasTrabalhadasValidas = 40;
        Double valorHoraValido = 70.00;
        int horasTrabalhadasEsperada = 40;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        int horasTrabalhadasObtida = funcionario.getHorasTrabalhadas();

        //Assert
        assertEquals(horasTrabalhadasEsperada, horasTrabalhadasObtida);
    }

    // Ana
    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é inválido e está fora do limite máximo de 40 horas")
    public void TestarHorasTrabalhadasInvalidasForaDoLimite() {
        //Arrange
        int horasTrabalhadasInvalidas = 45;
        Double valorHoraValido = 70.00;

        //Act and Assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            funcionario = new Funcionario("Ana Clara", horasTrabalhadasInvalidas, valorHoraValido);
        });
    }

    // Ana
    @Test
    @DisplayName("Verifica se o valor do pagamento é válido e não está no limite inferior de R$ 1320.00")
    public void TestarPagamentoValidoForaLimite() {
        //Arrange
        int horasTrabalhadasValidas = 30;
        Double valorHoraValido = 60.00;
        Double pagamentoEsperado = 1800.00;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        Double pagamentoObtido = funcionario.calcularPagamento();

        //Assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

    //Isabela
    @Test
    @DisplayName("Caso de teste para validar a construção com valor hora inválido.")
    public void testarConstrutorEntradaValorHoraInvalida() {
    
        //Arrange
        String nome = "Isabela";
        int horasTrabalhadasValidas = 40;
        double valorHoraInvalido = 300.00;

        //Act and assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            funcionario = new Funcionario(nome, horasTrabalhadasValidas, valorHoraInvalido);
        });
    }

     //Isabela
    @Test
    @DisplayName("Caso de teste para validar a modificação do valor hora com entrada válida.")
    public void testarModificarValorHoraEntradaValida() {
        // Arrange
        double valorHoraValida = 60.00;

        // Act
        funcionario.setValorHora(valorHoraValida);

        // Assert
        assertEquals(valorHoraValida, funcionario.getValorHora());
    }

     //Isabela
    @Test
    @DisplayName("Caso de teste para validar a construção com pagamento inválido.")
    public void testarConstrutorPagamentoInvalido() {
        // Arrange
        String nome = "João";
        int horasTrabalhadas = 10;
        double valorHora = 20.00;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario(nome, horasTrabalhadas, valorHora);
        });
    }

     //Isabela
    @Test
    @DisplayName("Caso de teste para validar um pagamento igual ao limite")
    public void testarConstrutorPagamentoNoLimite() {
        // Arrange
        int horasTrabalhadas = 20;
        double valorHora = 66.00;
        double pagamentoEsperado = 1320.00;

        // Act
        funcionario = new Funcionario("Isabela", horasTrabalhadas, valorHora);
        double pagamentoObtido = funcionario.calcularPagamento();

        // Assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

}
