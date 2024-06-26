package com.example.backendbase2.models;

import org.hibernate.annotations.ColumnDefault;

import com.example.backendbase2.models.validations.UniqueValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productos")
public class ProductoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  @NotNull(message = "Nombre del producto es obligatorio")
  @Column(nullable = false)
  private String nombre;

  @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
  @Column(nullable = false)
  private String descripcion;

  @NotNull(message = "SKU es obligatorio")
  @Column(nullable = false)
  private String sku;

  @Column(unique = true)
  @NotNull(message = "Código Barra es obligatorio")
  @UniqueValue
  private String codigoBarra;

  @NotNull(message = "Marca es obligatoria")
  @Column(nullable = false)
  private String marca;

  @Column(nullable = false)
  @ColumnDefault(value = "0.0")
  private double alto;

  @DecimalMin(value = "0.0", message = "Las dimensiones deben ser positivas")
  @Column(nullable = false)
  @ColumnDefault(value = "0.0")
  private double ancho;

  @DecimalMin(value = "0.0", message = "Las dimensiones deben ser positivas")
  @ColumnDefault(value = "0.0")
  @Column(nullable = false)
  private double largo;

  @DecimalMin(value = "0.0", message = "Las dimensiones deben ser positivas")
  @Column(nullable = false)
  @ColumnDefault(value = "0.0")
  private double profundidad;

  @DecimalMin(value = "0.0", message = "Las dimensiones deben ser positivas")
  @Column(nullable = false)
  @ColumnDefault(value = "0.0")
  private double peso;

  @NotNull(message = "Tipo de medida es obligatorio")
  @Column(nullable = false)
  private String tipoMedida;

  @DecimalMin(value = "0.0", message = "Las dimensiones deben ser positivas")
  @Column(nullable = false)
  @ColumnDefault(value = "0.0")
  private double volumenMts3;

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getSku() {
    return sku;
  }

  public String getCodigoBarra() {
    return codigoBarra;
  }

  public String getMarca() {
    return marca;
  }

  public double getAlto() {
    return alto;
  }

  public double getAncho() {
    return ancho;
  }

  public double getLargo() {
    return largo;
  }

  public double getProfundidad() {
    return profundidad;
  }

  public String getTipoMedida() {
    return tipoMedida;
  }

  public double getPeso() {
    return peso;
  }

  public double getVolumenMts3() {
    return volumenMts3;
  }

  @Override
  public String toString() {
    return "ProductoModel [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", sku=" + sku
        + ", codigoBarra=" + codigoBarra + ", marca=" + marca + ", alto=" + alto + ", ancho=" + ancho + ", largo="
        + largo + ", profundidad=" + profundidad + ", tipoMedida=" + tipoMedida + ", peso=" + peso + ", volumenMts3="
        + volumenMts3 + "]";
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public void setCodigoBarra(String codigoBarra) {
    this.codigoBarra = codigoBarra;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setAlto(double alto) {
    this.alto = alto;
  }

  public void setAncho(double ancho) {
    this.ancho = ancho;
  }

  public void setLargo(double largo) {
    this.largo = largo;
  }

  public void setProfundidad(double profundidad) {
    this.profundidad = profundidad;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setTipoMedida(String tipoMedida) {
    this.tipoMedida = tipoMedida;
  }

  public void setVolumenMts3(double volumenMts3) {
    this.volumenMts3 = volumenMts3;
  }

}
