package com.sua_empresa.model;

public class Aluno {
    private int id; // Adicionei o ID do aluno
    private String nome;
    private int idade;
    private String curso; // Nome do curso
    private String matricula;
    private int cursoId; // ID do curso
    private double notaMatematica; // Nota em Matemática
    private double notaPortugues; // Nota em Português

    // Construtor
    public Aluno(int id, String nome, int idade, String curso, String matricula, int cursoId) {
        this.id = id; // Inicializa o ID do aluno
        this.nome = nome;
        this.idade = idade;
        this.curso = curso; // Pode ser o nome do curso, se necessário
        this.matricula = matricula;
        this.cursoId = cursoId; // Inicializa o ID do curso
        this.notaMatematica = 0.0; // Inicializa a nota em Matemática
        this.notaPortugues = 0.0; // Inicializa a nota em Português
    }

    // Getters e Setters
    public int getId() {
        return id; // Retorna o ID do aluno
    }

    public void setId(int id) {
        this.id = id; // Permite alterar o ID do aluno
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCursoId() {
        return cursoId; // Retorna o ID do curso
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId; // Permite alterar o ID do curso
    }

    public double getNotaMatematica() {
        return notaMatematica; // Retorna a nota em Matemática
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica; // Permite alterar a nota em Matemática
    }

    public double getNotaPortugues() {
        return notaPortugues; // Retorna a nota em Português
    }

    public void setNotaPortugues(double notaPortugues) {
        this.notaPortugues = notaPortugues; // Permite alterar a nota em Português
    }
}
