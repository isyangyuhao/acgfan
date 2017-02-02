package org.acg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 画板类别实体类
 * @author yangyuhao
 */
@Table(name="PALETTE_TYPE")
@Entity
public class PaletteType {
	
	//画板类型id
	private Integer id;
	//类型名
	private String typeName;
	
	//映射双向一对多关联关系
	//该类型的画板
	private Set<Palette> palettes = new HashSet<>();
	//映射到Palette类中的paletteType属性
	@OneToMany(mappedBy="paletteType", fetch=FetchType.EAGER)
	public Set<Palette> getPalettes() {
		return palettes;
	}
	public void setPalettes(Set<Palette> palettes) {
		this.palettes = palettes;
	}
	
	public PaletteType() {
		
	}

	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="TYPE_NAME", nullable=false)
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
