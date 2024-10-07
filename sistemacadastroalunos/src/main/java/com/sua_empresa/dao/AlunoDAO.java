package com.sua_empresa.dao;

import com.sua_empresa.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, idade, curso, matricula) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setString(4, aluno.getMatricula());
            stmt.executeUpdate();
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT nome, idade, curso, matricula FROM alunos";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("curso"),
                    rs.getString("matricula"), 0
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return alunos;
    }

    public void excluir(String matricula) throws SQLException {
        String sql = "DELETE FROM alunos WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            stmt.executeUpdate();
        }
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE alunos SET nome = ?, idade = ?, curso = ? WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setString(4, aluno.getMatricula());
            stmt.executeUpdate();
        }
    }

    public Aluno buscarPorMatricula(String matricula) {
        String sql = "SELECT * FROM alunos WHERE matricula = ?";
        Aluno aluno = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aluno = new Aluno(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("curso"),
                    rs.getString("matricula"), 0
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }

    public void adicionarAluno(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarAluno'");
    }
    public List<Aluno> listarAlunosPorCurso(String cursoNome) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos WHERE curso_id = (SELECT id FROM cursos WHERE nome = ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cursoNome);
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                Aluno aluno = new Aluno(sql, 0, sql, sql, 0);
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setCursoId(rs.getInt("curso_id"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    
}
