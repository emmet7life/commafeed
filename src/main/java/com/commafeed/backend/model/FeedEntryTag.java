package com.commafeed.backend.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "FEEDENTRYTAGS")
@SuppressWarnings("serial")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Getter
@Setter
public class FeedEntryTag extends AbstractModel {

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JoinColumn(name = "entry_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private FeedEntry entry;

	@Column(name = "name", length = 40)
	private String name;

	public FeedEntryTag() {
	}

	public FeedEntryTag(User user, FeedEntry entry, String name) {
		this.name = name;
		this.entry = entry;
		this.user = user;
	}

}
