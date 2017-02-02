package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.stereotype.Repository;

/**
 * 展示画板实体类
 * @author yangyuhao
 */
@Table(name="PALETTE_SHOW")
@Entity
public class PaletteShow {
	
	//展示画板id
	private Integer id;
	//展示画板链接地址
	private String src;
	
	public PaletteShow() {
		
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

	@Column(name="SRC", nullable=false)
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
}
