package com.sua_empresa.model;

public class Aluno {
    private String nome;
    private int idade;
    private String curso; // Nome do curso (opcional, dependendo da sua lógica)
    private String matricula;
    private int cursoId; // ID do curso

    // Construtor
    public Aluno(String nome, int idade, String curso, String matricula, int cursoId) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso; // Pode ser o nome do curso, se necessário
        this.matricula = matricula;
        this.cursoId = cursoId; // Inicializa o ID do curso
    }

    // Getters e Setters
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

    public Object getNotaMatematica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNotaMatematica'");
    }

    public Object getNotaPortugues() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNotaPortugues'");
    }
}
