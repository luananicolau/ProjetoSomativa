package com.sua_empresa.Controller;

import com.sua_empresa.dao.AlunoDAO;
import com.sua_empresa.dao.CursoDAO;
import com.sua_empresa.model.Aluno;
import com.sua_empresa.model.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProfessorController {

    private AlunoDAO alunoDao;
    private CursoDAO cursoDao; // Supondo que você tenha um CursoDao para gerenciar cursos.

    public ProfessorController() {
        this.alunoDao = new AlunoDAO(null); // Certifique-se de passar a conexão se necessário.
        this.cursoDao = new CursoDAO(); // Certifique-se de passar a conexão se necessário.
    }

    public void mostrarFormularioGerarBoletim() {
        // Criar um novo JFrame para o formulário
        JFrame frame = new JFrame("Gerar Boletim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        List<Curso> cursos = cursoDao.listarCursos();
        
        JComboBox<Curso> comboCursos = new JComboBox<>(cursos.toArray(new Curso[0]));
        comboCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Curso cursoSelecionado = (Curso) comboCursos.getSelectedItem();
                if (cursoSelecionado != null) {
                    exibirAlunosPorCurso(cursoSelecionado, frame);
                }
            }
        });

        // Adiciona o JComboBox ao JFrame
        frame.add(comboCursos);
        frame.setVisible(true);
    }

    public void exibirAlunosPorCurso(Curso curso, JFrame frame) {
        List<Aluno> alunos = alunoDao.listarAlunosPorCurso(curso.getNome());

        String[] colunas = {"ID", "Nome", "Idade", "Matrícula"};
        Object[][] dados = new Object[alunos.size()][colunas.length];

        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            dados[i][0] = aluno.getCursoId(); // Usando cursoId do Aluno
            dados[i][1] = aluno.getNome();
            dados[i][2] = aluno.getIdade();
            dados[i][3] = aluno.getMatricula();
        }

        JTable tabelaAlunos = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBounds(30, 50, 300, 150);
        frame.add(scrollPane);

        // Adicionando um botão para gerar o boletim
        JButton botaoGerarBoletim = new JButton("Gerar Boletim");
        botaoGerarBoletim.setBounds(30, 210, 150, 25);
        botaoGerarBoletim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaAlunos.getSelectedRow();
                if (selectedRow != -1) {
                    Aluno alunoSelecionado = alunos.get(selectedRow);
                    gerarBoletim(alunoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um aluno da tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        frame.add(botaoGerarBoletim);
        frame.revalidate(); // Revalida o frame para atualizar a interface
        frame.repaint(); // Repaint para garantir que a interface gráfica seja atualizada
    }

    public void gerarBoletim(Aluno aluno) {
        // Lógica para gerar o boletim do aluno
        // Aqui você pode implementar a lógica para criar o boletim, por exemplo, abrir uma nova tela com as notas
        JOptionPane.showMessageDialog(null, "Boletim gerado para: " + aluno.getNome());
    }
}
