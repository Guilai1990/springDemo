package com.smart.dao;

import com.smart.domain.Board;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class BoardDaoTest extends BaseDaoTest{

    @SpringBean("boardDao")
    private BoardDao boardDao;

    @Test
    @ExpectedDataSet("Xiaochun.ExpectedBoards.xls")
    public void addBoard() throws Exception {
        List<Board> boards = XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "XiaoChun.SaveBoards.xls", "t_board", Board.class);
        for (Board board : boards) {
            boardDao.update(board);
        }
    }

    @Test
    @DataSet(value = "XiaoChun.Boards.xls")
    @ExpectedDataSet("XiaoChun.ExpectedBoards.xls")
    public void removeBoard() {
        Board board = boardDao.get(7);
        boardDao.remove(board);
    }



    @Test
    @DataSet("XiaoChun.Boards.xls")
    public void getBoard() {
        Board board = boardDao.load(1);

        assertNotNull(board);
        assertEquals(board.getBoardName(), "Spring Boot");
    }


}
