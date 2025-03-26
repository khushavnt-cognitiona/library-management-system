package com.laibary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fines")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
    
    private Double amount;
    private Boolean paid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public Fine(Long id, Loan loan, Double amount, Boolean paid) {
		super();
		this.id = id;
		this.loan = loan;
		this.amount = amount;
		this.paid = paid;
	}
	public Fine() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
