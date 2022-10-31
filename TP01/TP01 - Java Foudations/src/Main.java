import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static final String REGISTER = "Cadastro do Aluno";

    public static void main(String[] args) {
        startMenu();
    }

    private static void startMenu() {
        String[] students = new String[100];
        int[] AV1 = new int[100];
        int[] AV2 = new int[100];

        while(true) {
            Scanner scanner = new Scanner(System.in);
//            System.out.println("""
//                    [1] - Cadastrar aluno
//                    [2] - Consultar boletim de um aluno
//                    [3] - Consultar boletim de todos os alunos
//                    [4] - Sair""");
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    [1] - Cadastrar aluno
                    [2] - Consultar boletim de um aluno
                    [3] - Consultar boletim de todos os alunos
                    [4] - Sair""", "Escolha uma opção", JOptionPane.INFORMATION_MESSAGE));

            switch (option) {
                case 1 ->  registerStudent(scanner, students, AV1, AV2);
                case 2 -> consultStudent(students, AV1, AV2);
                case 3 -> consultAllStudents(students, AV1, AV2);
                case 4 -> { break; }
                default -> System.out.println("Opção inválida!");
            }
            if (option == 4) break;
        }
    }

    private static void consultAllStudents(String[] students, int[] av1, int[] av2) {
        for (int i = 0; i < students.length; i++) {
            String name = students[i];
            int AV1 = av1[i];
            int AV2 = av2[i];
            Double average = (AV1 + AV2) / 2d;
            Enum situation;
            if (average < 4) {
                situation = Situation.FAILED;
            } else if (average < 7) {
                situation = Situation.FINAL_EXAM;
            } else {
                situation = Situation.APPROVED;
            }
            if(i == 0 && students[i] == null) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (students[i] == null) {
                JOptionPane.showMessageDialog(null, "Fim da lista");
                return;
            }
            consultStudent(students, av1, av2, i);
//            System.out.printf("""
//                Nome: %s
//                AV1: %d
//                AV2: %d
//                Média Final: %d
//                Situação: %s
//                %n""", name, AV1, AV2, average, situation);
        }

    }

    public static void consultStudent(String[] students, int[] AV1, int[] AV2) {
        int code = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Digite o código do aluno: ", REGISTER, JOptionPane.INFORMATION_MESSAGE));
        consultStudent(students, AV1, AV2, code);
    }
    public static void consultStudent(String[] students, int[] AV1, int[] AV2, int code) {
        if (students[code] == null) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
            return;
        }
        int grade = (AV1[code] + AV2[code]) / 2;
        if (grade < 4) {
            printSituation(students[code], AV1[code], AV2[code], Situation.FAILED.getStatus());
        } else if (grade < 7) {
            printSituation(students[code], AV1[code], AV2[code], Situation.FINAL_EXAM.getStatus());
        } else {
            printSituation(students[code], AV1[code], AV2[code], Situation.APPROVED.getStatus());
        }
    }

    public static void printSituation(String name, int AV1, int AV2, String situation) {
        JOptionPane.showMessageDialog(null, String.format("""
                Nome: %s
                AV1: %d
                AV2: %d
                Média Final: %d
                Situação: %s
                %n""", name, AV1, AV2, (AV1 + AV2) / 2, situation), "Relatório", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int checkValidIndexPosition(String[] arr) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Array is full!");
    }
    public static void registerStudent(Scanner sc, String[] students, int[] AV1, int[] AV2) {
        int index = 0;
        try {
            index = checkValidIndexPosition(students);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Máximo de estudantes registrados");
            return;
        }
        students[index] = JOptionPane.showInputDialog(null, "Digite o nome do aluno", REGISTER, JOptionPane.INFORMATION_MESSAGE);
        AV1[index] =  Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a nota da AV1", REGISTER, JOptionPane.INFORMATION_MESSAGE));
        System.out.println("Digite a nota da AV2");
        AV2[index] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a nota da AV2", REGISTER, JOptionPane.INFORMATION_MESSAGE));
        String textBlock = String.format("""
                Aluno cadastrado com sucesso!
                Nome: %s
                AV1: %d
                AV2: %d
                Código: %d
                """, students[index], AV1[index], AV2[index], index);
        JOptionPane.showMessageDialog(null, textBlock);
    }
    enum Situation {
        APPROVED("Aprovado"), FINAL_EXAM("Prova Final"), FAILED("Reprovado");

        private String status;
        Situation(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}