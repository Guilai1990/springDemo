package com.smart.dao;

import java.util.Iterator;
import com.smart.domain.Board;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends BaseDao<Board> {
    private static final String GET_BOARD_NUM = "select count(f.boardId) from Board f";

    public long getBoardNum() {
        Iterator iter = getHibernateTemplate().iterate(GET_BOARD_NUM);
        return ((Long) iter.next());
    }

}
