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

package edu.atlas.games.input;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public enum Keys
{

	BACKSPACE(8, "Backspace"),
	TAB(9, "Tab"),
	ENTER(13, "Enter"),
	SHIFT(16, "Shift"),
	CONTROL(17, "Control"),
	ALT(18, "Alt"),
	PAUSE_BREAK(19, "Pause break"),
	CAPSLOCK(20, "Capslock"),
	ESCAPE(27, "Escape"),
	SPACEBAR(32, "Spacebar"),
	PAGE_UP(33, "Page Up"),
	PAGE_DOWN(34, "Page Down"),
	END(35, "End"),
	HOME(36, "Home"),
	LEFT_ARROW(37, "Left Arrow"),
	UP_ARROW(38, "Up Arrow"),
	RIGHT_ARROW(39, "Right Arrow"),
	DOWN_ARROW(40, "Down Arrow"),
	INSERT(45, "Insert"),
	DELETE(46, "Delete"),
	ZERO(48, "0"),
	ONE(49, "1"),
	TWO(50, "2"),
	THREE(51, "3"),
	FOUR(52, "4"),
	FIVE(53, "5"),
	SIX(54, "6"),
	SEVEN(55, "7"),
	EIGHT(56, "8"),
	NINE(57, "9"),
	A(65, "a"),
	B(66, "b"),
	C(67, "c"),
	D(68, "d"),
	E(69, "e"),
	F(70, "f"),
	G(71, "g"),
	H(72, "h"),
	I(73, "i"),
	J(74, "j"),
	K(75, "k"),
	L(76, "l"),
	M(77, "m"),
	N(78, "n"),
	O(79, "o"),
	P(80, "p"),
	Q(81, "q"),
	R(82, "r"),
	S(83, "s"),
	T(84, "t"),
	U(85, "u"),
	V(86, "v"),
	W(87, "w"),
	X(88, "x"),
	Y(89, "y"),
	Z(90, "z"),
	LEFT_WINDOW(91, "Left Window"),
	RIGHT_WINDOW(92, "Right Window"),
	SELECT(93, "Select"),
	NUMPAD_ZERO(96, "Numpad 0"),
	NUMPAD_ONE(97, "Numpad 1"),
	NUMPAD_TWO(98, "Numpad 2"),
	NUMPAD_THREE(99, "Numpad 3"),
	NUMPAD_FOUR(100, "Numpad 4"),
	NUMPAD_FIVE(101, "Numpad 5"),
	NUMPAD_SIX(102, "Numpad 6"),
	NUMPAD_SEVEN(103, "Numpad 7"),
	NUMPAD_EIGHT(104, "Numpad 8"),
	NUMPAD_NINE(105, "Numpad 9"),
	MULTIPLY(106, "Multiply"),
	ADD(107, "Add"),
	SUBSTRACT(109, "Substract"),
	DECIMAL(110, "Decimal"),
	DIVIDE(111, "Divide"),
	F_ONE(112, "F1"),
	F_TWO(113, "F2"),
	F_THREE(114, "F3"),
	F_FOUR(115, "F4"),
	F_FIVE(116, "F5"),
	F_SIX(117, "F6"),
	F_SEVEN(118, "F7"),
	F_EIGHT(119, "F8"),
	F_NINE(120, "F9"),
	F_TEN(121, "F10"),
	F_ELEVEN(122, "F11"),
	F_TWELVE(123, "F12"),
	NUM_LOCK(144, "Num lock"),
	SCROLL_LOCK(145, "Scroll lock"),
	SEMICOLON(186, "Semi-colon"),
	EQUAL_SIGN(187, "Equal sign"),
	COMMA(188, "Comma"),
	DASH(189, "Dash"),
	PERIOD(190, "Period"),
	FORWARD_SLASH(191, "Forward slash"),
	GRAVE_ACCENT(192, "Grave accent"),
	OPEN_BRACKET(219, "Open bracket"),
	BACKSLASH(220, "Back slash"),
	CLOSE_BRACKET(221, "Close bracket"),
	SINGLE_QUOTE(222, "Single quote");
	
	private int code;
	private String name;
	
	private Keys(int code, String name)
	{
		this.code = code;
		this.name = name;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static Keys getKeyByCode(int code)
	{
		for(Keys key : Keys.values())
		{
			if(key.getCode() == code)
			{
				return key;
			}
		}
		return null;
	}
}
