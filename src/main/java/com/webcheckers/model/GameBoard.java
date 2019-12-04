package com.webcheckers.model;

public class GameBoard {
    //... or something like this
    Tile[] p1PieceList;
    Tile[] p2PieceList;
    Tile[][] board;

    public GameBoard() {
        p1PieceList = new Tile[30];
        p2PieceList = new Tile[30];
        board = new Tile[8][8];

        //Initialize loops
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                board[i][j] = new Tile();
            }
        }

        for(int i=0; i< p1PieceList.length; i++) {
            p1PieceList[i] = new Tile();
        }

        for(int i=0; i< p1PieceList.length; i++) {
            p1PieceList[i] = new Tile();
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile[] getPlayerOnePieceList() {
        return p1PieceList;
    }

    public Tile[] getPlayerTwoPieceList() {
        return p2PieceList;
    }

    public GamePiece removePiece(GamePiece pieceToRemove) {
        int removeX, removeY;
        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j].piece == pieceToRemove) {
                    removeX = i;
                    removeY = j;

                    GamePiece toReturn = board[removeX][removeY].piece;
                    board[removeX][removeY].piece = null;
                    return toReturn;
                }
            }
        }
        return null;
    }

    public void addPiece(int xCoord, int yCoord, GamePiece pieceToAdd) {
        board[xCoord][yCoord].piece = pieceToAdd;
    }

    public int getRemainingPieces(){
        int remainingPieces = 0;
        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j].piece != null) {
                    remainingPieces++;
                }
            }
        }
        return remainingPieces;
    }

}
