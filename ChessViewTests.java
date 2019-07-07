package swen221.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import org.junit.Test;

import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.moves.SinglePieceMove;
import swen221.chessview.pieces.*;

public class ChessViewTests {

	@Test public void test01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test02() {
		String input =
			"a2-a3 b7-b6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|p|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test03() {
		String input =
			"a2-a4 b7-b5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|p|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	@Test public void test04() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|p|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test05() {
		String input =
			"d2-d3 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"d3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test06() {
		String input =
			"Nb1-c3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test07() {
		String input =
			"Nb1-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|N|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test08() {
		String input =
			"d2-d4 Nb8-c6\n" +
			"e2-e4 Nc6xd4\n" +
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|n|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test09() {
		String input =
			"Nb1-c3 e7-e5\n" +
			"e2-e3 e5-e4\n" +
			"Nc3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|N|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test10() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|B|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test11() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5-h4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|B|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test12() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5xe7\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|B|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test13() {
		String input =
			"e2-e4 e7-e5\n" +
			"Qd1-g4 Qd8-h4\n" +
			"Qg4-f4 Qh4-h6\n" +
			"Qf4-f6 Qh6xh2\n" +
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|Q|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|q|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	@Test public void test14() {
		String input =
			"a2-a4 h7-h5\n" +
			"Ra1-a3 Rh8-h6\n" +
			"Ra3-d3 Rh6-g6\n" +
			"Rd3xd7\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Test castling on the kingside for white
	@Test public void test15() {
		String input =
			"e2-e4 h7-h5\n" +
			"Bf1-d3 Rh8-h6\n" +
			"Ng1-f3 Rh6-g6\n" +
			"O-O\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|B|_|N|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|_|R|K|_|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Test castling on the queenside black
	@Test public void test16() {
		String input =
				"e2-e4 d7-d5\n" +
				"Bf1-d3 Nb8-a6\n" +
				"Ng1-f3 Bc8-e6\n" +
				"O-O Qd8-d6\n" +
				"c2-c3 O-O-O\n" +
				"";
		String output =
			"8|_|_|k|r|_|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|n|_|_|q|b|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|P|B|_|N|_|_|\n" +
			"2|P|P|_|P|_|P|P|P|\n" +
			"1|R|N|B|Q|_|R|K|_|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Check that the pawn diagonal take works
	@Test public void test17() {
		String input =
				"e2-e4 d7-d5\n" +
				"e4xd5\n" +
				"";
		
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|_|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|P|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Test that the Bishop, Rook, Knight and King can move 
	@Test public void test18() {
		String input =
			"e2-e4 h7-h5\n" +
			"Bf1-d3 Rh8-h6\n" +
			"Ng1-f3 Rh6-g6\n" +
			"Ke1-f1\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|B|_|N|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|_|K|_|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Test that King can't move more than one square
	@Test public void test19() {
		String input =
			"e2-e4 h7-h5\n" +
			"Bf1-d3 Rh8-h6\n" +
			"Ng1-f3 Rh6-g6\n" +
			"Ke1-g1\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|p|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|B|_|N|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|N|B|Q|K|_|_|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Check that the white pawn works
	@Test public void test20() {
		SinglePieceMove m = new SinglePieceMove(new Pawn(false),new Position(1,1), new Position(2,1));
		assertEquals("a1-a2",m.toString());
	}
	
	//Check that the black pawn works
	@Test public void test21() {
		Pawn p = new Pawn(false);
		SinglePieceMove m = new SinglePieceMove(p,new Position(1,1), new Position(2,1));
		assertEquals(p,m.piece());
	}
	
	//Check that the old position is right
	@Test public void test22() {
		Pawn p = new Pawn(false);
		Position old = new Position(1,1);
		Position newP = new Position(2,1);
		SinglePieceMove m = new SinglePieceMove(p,old, newP);
		assertEquals(old,m.oldPosition());
	}
	
	//Check that the new position is right
	@Test public void test23() {
		Pawn p = new Pawn(false);
		Position old = new Position(1,1);
		Position newP = new Position(2,1);
		SinglePieceMove m = new SinglePieceMove(p,old, newP);
		assertEquals(newP,m.newPosition());
	}
	
	//Check that the white knight works
	@Test public void test24() {
		SinglePieceMove m = new SinglePieceMove(new Knight(true),new Position(1,1), new Position(3,2));
		assertEquals("Na1-b3",m.toString());
	}
	
	//Check that the black Bishop works
	@Test public void test25() {
		SinglePieceMove m = new SinglePieceMove(new Bishop(false),new Position(1,1), new Position(2,2));
		assertEquals("Ba1-b2",m.toString());
	} 
	
	//Check that the black Rook works
	@Test public void test26() {
		SinglePieceMove m = new SinglePieceMove(new Rook(false),new Position(1,1), new Position(2,1));
		assertEquals("Ra1-a2",m.toString());
	}
	
	//Check that the black Queen works
	@Test public void test27() {
		SinglePieceMove m = new SinglePieceMove(new Queen(false),new Position(1,1), new Position(2,1));
		assertEquals("Qa1-a2",m.toString());
	}
	
	//Check that the black king works
	@Test public void test28() {
		SinglePieceMove m = new SinglePieceMove(new King(false),new Position(1,1), new Position(2,1));
		assertEquals("Ka1-a2",m.toString());
	}
	
	//Check whiterookMoved is true
	@Test public void test29() {
		SinglePieceMove m = new SinglePieceMove(new Rook(true),new Position(1,8), new Position(1,6));
		assertEquals("Rh1-f1",m.toString());
	}
	
	//Check that whiterookMoved is true
	@Test public void test30() {
		SinglePieceMove m = new SinglePieceMove(new Rook(true),new Position(8,8), new Position(8,6));
		assertEquals("Rh8-f8",m.toString());
	}
	
	//Check that blackRookMoved is true
	@Test public void test31() {
		SinglePieceMove m = new SinglePieceMove(new Rook(false),new Position(1,8), new Position(1,6));
		assertEquals("Rh1-f1",m.toString());
	}
	
	//Check that blackRookMoved is true
	@Test public void test32() {
		SinglePieceMove m = new SinglePieceMove(new Rook(false),new Position(8,1), new Position(8,3));
		assertEquals("Ra8-c8",m.toString());
	}
	
	//Check that all the rookMoved variables are true
	@Test public void test33() {
		String input =
			"a2-a3 a7-a6\n" +
			"Ra1-a2 Ra8-a7\n" +
			"h2-h3 h7-h6\n" +
			"Rh1-h2 Rh8-h7\n" +
			"";
		String output =
			"8|_|n|b|q|k|b|n|_|\n" +
			"7|r|p|p|p|p|p|p|r|\n" +
			"6|p|_|_|_|_|_|_|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|P|\n" +
			"2|R|P|P|P|P|P|P|R|\n" +
			"1|_|N|B|Q|K|B|N|_|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Check that all the pieces can be taken
	@Test public void test34() {
		String input =
				"d2-d4 d7-d5\n" +
				"Qd1-d3 Qd8-d6\n" +
				"Bc1-f4 Bc8-f5\n" +
				"Qd3xBf5 Qd6xBf4\n" +
				"Qf5xQf4 Ng8-f6\n" +
				"Qf4xNf6 e7-e6\n" +
				"Qf6xg7 Bf8-c5\n" +
				"Qg7xRh8+\n" +
				"";
		String output =
				"8|r|n|_|_|k|_|_|Q|\n" +
				"7|p|p|p|_|_|p|_|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|b|p|_|_|_|_|\n" +
				"4|_|_|_|P|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|_|P|P|P|P|\n" +
				"1|R|N|_|_|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that en passant works
	@Test public void test35() {
		String input =
				"e2-e4 e7-e5\n" +
				"Ng1-f3 Ng8-f6\n" +
				"d2-d4 e5xd4\n" +
				"e4-e5 Nf6-e4\n" +
				"Qd1xd4 d7-d5\n" +
				"e5xd6ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|_|r|\n" +
				"7|p|p|p|_|_|p|p|p|\n" +
				"6|_|_|_|P|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|Q|n|_|_|_|\n" +
				"3|_|_|_|_|_|N|_|_|\n" +
				"2|P|P|P|_|_|P|P|P|\n" +
				"1|R|N|B|_|K|B|_|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that this en passant is invalid
	@Test public void test42() {
		String input =
				"e2-e4 e7-e5\n" +
				"Ng1-f3 Ng8-f6\n" +
				"d2-d4 e5xd4\n" +
				"e4-e5 Nf6-e4\n" +
				"Qd1xd4 d7-d6\n" +
				"Qd4xNe4 d6-d5\n" +
				"e5xd6ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|_|r|\n" +
				"7|p|p|p|_|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|p|P|_|_|_|\n" +
				"4|_|_|_|_|Q|_|_|_|\n" +
				"3|_|_|_|_|_|N|_|_|\n" +
				"2|P|P|P|_|_|P|P|P|\n" +
				"1|R|N|B|_|K|B|_|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that the black king can move forward
	@Test public void test36() {
		String input =
				"e2-e3 e7-e6\n" +
				"e3-e4 Ke8-e7\n" +
				"";
		String output =
				"8|r|n|b|q|_|b|n|r|\n" +
				"7|p|p|p|p|k|p|p|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|P|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that the white king can move forward
	@Test public void test37() {
		String input =
				"e2-e3 e7-e6\n" +
				"Ke1-e2\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|p|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|P|_|_|_|\n" +
				"2|P|P|P|P|K|P|P|P|\n" +
				"1|R|N|B|Q|_|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that pawn can be promoted to Queen
	@Test public void test38() {
		String input =
				"a2-a4 b7-b5\n" +
				"a4xb5 Nb8-c6\n" +
				"b5-b6 a7-a5\n" +
				"b6-b7 d7-d5\n" +
				"b7-b8=Q\n" +
				"";
		String output =
				"8|r|Q|b|q|k|b|n|r|\n" +
				"7|_|_|p|_|p|p|p|p|\n" +
				"6|_|_|n|_|_|_|_|_|\n" +
				"5|p|_|_|p|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that pawn can be promoted to Knight
	@Test public void test39() {
		String input =
				"a2-a4 b7-b5\n" +
				"a4xb5 Nb8-c6\n" +
				"b5-b6 a7-a5\n" +
				"b6-b7 d7-d5\n" +
				"b7-b8=N\n" +
				"";
		String output =
				"8|r|N|b|q|k|b|n|r|\n" +
				"7|_|_|p|_|p|p|p|p|\n" +
				"6|_|_|n|_|_|_|_|_|\n" +
				"5|p|_|_|p|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that pawn can be promoted to rook
	@Test public void test40() {
		String input =
				"a2-a4 b7-b5\n" +
				"a4xb5 Nb8-c6\n" +
				"b5-b6 a7-a5\n" +
				"b6-b7 d7-d5\n" +
				"b7-b8=R\n" +
				"";
		String output =
				"8|r|R|b|q|k|b|n|r|\n" +
				"7|_|_|p|_|p|p|p|p|\n" +
				"6|_|_|n|_|_|_|_|_|\n" +
				"5|p|_|_|p|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that pawn can be promoted to bishop
	@Test public void test41() {
		String input =
				"a2-a4 b7-b5\n" +
				"a4xb5 Nb8-c6\n" +
				"b5-b6 a7-a5\n" +
				"b6-b7 d7-d5\n" +
				"b7-b8=B\n" +
				"";
		String output =
				"8|r|B|b|q|k|b|n|r|\n" +
				"7|_|_|p|_|p|p|p|p|\n" +
				"6|_|_|n|_|_|_|_|_|\n" +
				"5|p|_|_|p|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";
		checkValid(input,output);
	}
	
	//Check that the blackkingside castling and whitequeenside castling work
	@Test public void test43() {
		String input =
			"d2-d4 e7-e5\n" +
			"Qd1-d3 Bf8-d6\n" +
			"Bc1-e3 Ng8-h6\n" +
			"Nb1-a3 O-O\n" +
			"O-O-O\n" +
			"";
		String output =
			"8|r|n|b|q|_|r|k|_|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|b|_|_|_|n|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|N|_|_|Q|B|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|_|_|K|R|_|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}
	
	//Check that both Kings can move diagonally
	@Test public void test44() {
		String input =
			"d2-d4 d7-d5\n" +
			"Ke1-d2 Ke8-d7\n" +
			"";
		String output =
			"8|r|n|b|q|_|b|n|r|\n" +
			"7|p|p|p|k|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|K|P|P|P|P|\n" +
			"1|R|N|B|Q|_|B|N|R|\n" +
			"  a b c d e f g h";

		checkValid(input,output);
	}

	// The following provides a simple helper method for all tests.
	public static void checkValid(String input, String expectedOutput) {
		try {
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty()) {
				fail("test failed with insufficient boards on input: " + input);
			}
			String actualOutput = boards.get(boards.size() - 1).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}
	}
	
}
