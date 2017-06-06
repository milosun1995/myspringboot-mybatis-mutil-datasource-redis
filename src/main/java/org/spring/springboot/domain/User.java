package org.spring.springboot.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", description=" + description + ", city=" + city + "]";
	}   
}
