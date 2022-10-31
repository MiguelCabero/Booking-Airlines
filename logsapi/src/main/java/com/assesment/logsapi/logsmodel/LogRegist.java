package com.assesment.logsapi.logsmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "analytics")
public class LogRegist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "client_ip")
	private String clientIp;

	@Column(name = "timestamp_start")
	private String timestampStart;

	@Column(name = "timestamp_end")
	private String timestampEnd;

	public LogRegist() {
	}

	public LogRegist(Integer id, String clientIp,
			String sessionStart) {
		this.id = id;
		this.clientIp = clientIp;
		this.timestampStart = sessionStart;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getTimestampStart() {
		return timestampStart;
	}

	public void setTimestampStart(String timestampStart) {
		this.timestampStart = timestampStart;
	}

	public String getTimestampEnd() {
		return timestampEnd;
	}

	public void setTimestampEnd(String timestampEnd) {
		this.timestampEnd = timestampEnd;
	}

	@Override
	public String toString() {
		return "LogRegist [id=" + id + ", clientIp=" + clientIp
				+ ", sessionStart=" + timestampStart + ", sessionEnd="
				+ timestampEnd + "]";
	}

}
