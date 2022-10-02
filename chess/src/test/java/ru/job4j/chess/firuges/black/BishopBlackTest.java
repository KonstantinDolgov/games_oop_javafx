package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        Cell result = bishopBlack.position();
        Cell expected = Cell.D8;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.G1);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G1");
    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        Figure figure = bishopBlack.copy(Cell.A5);
        Cell result = figure.position();
        Cell expected = Cell.A5;
        assertThat(result).isEqualTo(expected);
    }
}