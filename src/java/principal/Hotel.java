package principal;

import java.io.Serializable;

/**
 *
 */
public class Hotel implements Serializable{
    /**
     * Cidade do hotel
     */
    private String city;
    /**
     * Tamanho do quarto, numero de quartos daquele tamanho
     */
    private Integer price;

    /**
     * Retorna nome do hotel
     * @return nome do hotel
     */
    public String getCity() {
        return city;
    }

    /**
     * Define nome do hotel
     * @param city nome do hotel
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retorna preço do hotel
     * @return preço do hotel
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Define preço do hotel
     * @param price preço do hotel
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

}
