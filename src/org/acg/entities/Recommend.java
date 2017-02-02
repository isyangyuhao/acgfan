package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 画板推荐实体类
 * @author yangyuhao
 */
@Table(name="RECOMMEND")
@Entity
public class Recommend {
	
	private Integer id;
	private Palette palette;
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JoinColumn(name="PALETTE_ID")
	@OneToOne(fetch=FetchType.EAGER)
	public Palette getPalette() {
		return palette;
	}
	public void setPalette(Palette palette) {
		this.palette = palette;
	}
	
}
