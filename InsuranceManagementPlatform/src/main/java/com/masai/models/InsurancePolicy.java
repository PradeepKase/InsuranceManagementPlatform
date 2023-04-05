package com.masai.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max=10)
    private String policyNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double coverageAmount;

    @Column(nullable = false)
    private Double premium;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    
    //getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public InsurancePolicy() {
		// TODO Auto-generated constructor stub
	}

	public InsurancePolicy(Long id, String policyNumber, String type, Double coverageAmount, Double premium,
			LocalDate startDate, LocalDate endDate, Client client) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}

    
    
    
}
