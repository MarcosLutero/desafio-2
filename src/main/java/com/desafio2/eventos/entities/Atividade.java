package com.desafio2.eventos.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
	public class Atividade {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;
	    private String descricao;
	    private Double preco;

	    @ManyToOne
	    @JoinColumn(name = "categoria_id")
	    private Categoria categoria;

	    @ManyToMany
	    @JoinTable(
	        name = "atividade_participante",
	        joinColumns = @JoinColumn(name = "atividade_id"),
	        inverseJoinColumns = @JoinColumn(name = "participante_id")
	    )
	    private List<Participante> participantes;

	    @OneToMany(mappedBy = "atividade")
	    private List<Bloco> blocos;

		public Atividade() {
			
		}

		public Atividade(Long id, String nome, String descricao, Double preco, Categoria categoria,
				List<Participante> participantes, List<Bloco> blocos) {
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.categoria = categoria;
			this.participantes = participantes;
			this.blocos = blocos;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public List<Participante> getParticipantes() {
			return participantes;
		}

		public List<Bloco> getBlocos() {
			return blocos;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Atividade other = (Atividade) obj;
			return Objects.equals(id, other.id);
		}
		

		

	}

