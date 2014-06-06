/*
 * Copyright (C) 2014, David Verhaak
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.atlas.games.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.2
 */
public class Database
{

	private String host;
	private String database;
	private String username;
	private String password;
	private String type;
	private Connection connection;

	/**
	 *
	 * @todo Write documentation
	 * @param host
	 * @param database
	 * @param username
	 * @param password
	 * @param type
	 * @since 0.2
	 */
	public Database(String host, String database, String username, String password, String type)
	{
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param host
	 * @param database
	 * @param username
	 * @param password
	 * @since 0.2
	 */
	public Database(String host, String database, String username, String password)
	{
		this(host, database, username, password, "mysql");
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public boolean open() throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:" + type + "://" + host + "/" + database, username, password);
		return connection != null;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public boolean close() throws SQLException
	{
		if (connection != null && !connection.isClosed())
		{
			connection.close();
			return true;
		}
		return false;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param query
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public PreparedStatement prepare(String query) throws SQLException
	{
		return connection.prepareStatement(query);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param query
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param query
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public boolean execute(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		return statement.execute(query);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param query
	 * @return
	 * @throws SQLException
	 * @since 0.2
	 */
	public int executeUpdate(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		return statement.executeUpdate(host);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getHost()
	{
		return host;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param host
	 * @since 0.2
	 */
	public void setHost(String host)
	{
		this.host = host;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getDatabase()
	{
		return database;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param database
	 * @since 0.2
	 */
	public void setDatabase(String database)
	{
		this.database = database;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param username
	 * @since 0.2
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param password
	 * @since 0.2
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getType()
	{
		return type;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param type
	 * @since 0.2
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public Connection getConnection()
	{
		return connection;
	}
}
