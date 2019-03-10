package natashadihtiar;
import java.util.Random;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main
{
    private static final int SIZE = 3;
    private static int[][] field = new int[SIZE][SIZE];
    private static int turn = 1;

    public static void DrawField()
    {
        for (final int[] row : field)
        {
            for (final int cell : row)
            {
                System.out.print("\t" + (cell == 0 ? " " : cell == 1 ? "X" : "O") + "\t|");
            }
            System.out.println("\n _______________________");
        }
        System.out.println();
    }

    public static void Step()
    {
        final Random random = new Random();
        int row = 1;
        int column = 1;

        while (field[row][column] != 0)
        {
            row = random.nextInt(SIZE);
            column = random.nextInt(SIZE);
        }
        field[row][column] = turn;
        turn = turn == 1 ? 2 : 1;
    }

    public static void main(final String[] args)
    {
        // System.out.println(Arrays.toString(args));
        DrawField();
        turn = new Random().nextInt(2) + 1;
        for (int i = 0; i < SIZE * SIZE; i++)
        {
            Step();
            DrawField();
            if (checkVictory())
            {if(turn == 2)
            {
                System.out.println("X" + " is winner");

            }
            else
                System.out.println("0" + " is winner");
            return;
            }
        }
        System.out.println("Draw!");
    }

    public static boolean checkVictory()
    {
        boolean isVictory = false;

        for (int row = 0; row < SIZE; row++)
        {
            for (int column = 0; column < SIZE - 1; column++)
            {
                if (field[row][column] != 0 && field[row][column] == field[row][column + 1])
                {
                    isVictory = true;
                }
                else
                {
                    isVictory = false;
                    break;
                }
            }
            if (isVictory)
            {
                break;
            }
        }
        if (!isVictory)
        {
            for (int column = 0; column < SIZE; column++)
            {
                for (int row = 0; row < SIZE - 1; row++)
                {
                    if (field[row][column] != 0 && field[row][column] == field[row + 1][column])
                    {
                        isVictory = true;
                    }
                    else
                    {
                        isVictory = false;
                        break;
                    }
                }
                if (isVictory)
                {
                    break;
                }
            }
        }

        if (!isVictory)
        {
            for (int column = 0; column < SIZE - 1; column++)
            {
                if (field[column][column] != 0 && field[column][column] == field[column + 1][column + 1])
                {
                    isVictory = true;
                }
                else
                {
                    isVictory = false;
                    break;
                }
            }
        }


        if (!isVictory)
        {
            for (int column = 0; column < SIZE - 1; column++)
            {
                if (field[column][column] != 0 && field[column][SIZE - column - 1] == field[column + 1][SIZE - column - 2])
                {
                    isVictory = true;
                }
                else
                {
                    isVictory = false;
                    break;
                }
            }
        }

        return isVictory;
    }
}
