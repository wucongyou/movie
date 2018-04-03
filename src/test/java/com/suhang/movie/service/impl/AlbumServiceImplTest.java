package com.suhang.movie.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.suhang.movie.MockTests;
import com.suhang.movie.dao.impl.AlbumCacheDaoImpl;
import com.suhang.movie.dao.impl.AlbumDaoImpl;
import com.suhang.movie.model.Album;

/**
 * @author hang.su
 * @since 2018-04-03 下午12:26
 */
public class AlbumServiceImplTest extends MockTests {

    @Mock
    AlbumServiceImpl albumService;

    @Mock
    AlbumDaoImpl albumDao;

    @Mock
    AlbumCacheDaoImpl albumCacheDao;

    @Before
    public void setUp() throws Exception {
        setField(albumService, "albumDao", albumDao);
        setField(albumService, "albumCacheDao", albumCacheDao);
    }

    @Test
    public void getWhenCacheHits() {
        when(albumService.get(anyInt())).thenCallRealMethod();
        // stub
        long id = 1;
        Album cachedAlbum = mockAlbum(id);
        when(albumCacheDao.get(id)).thenReturn(cachedAlbum);

        Album a = albumService.get(id);
        assertEquals(cachedAlbum, a);

        verify(albumCacheDao, times(1)).get(id);
        verify(albumDao, times(0)).get(id);
    }

    @Test
    public void getFromDBOKWhenCacheMiss() {
        when(albumService.get(anyInt())).thenCallRealMethod();
        // stub
        long id = 1;

        when(albumCacheDao.get(id)).thenReturn(null);

        Album dbAlbum = mockAlbum(id);
        when(albumDao.get(id)).thenReturn(dbAlbum);

        Album a = albumService.get(id);
        assertEquals(dbAlbum, a);

        verify(albumCacheDao, times(1)).get(id);
        verify(albumDao, times(1)).get(id);
    }

    @Test
    public void getFromDBMissWhenCacheMiss() {
        when(albumService.get(anyInt())).thenCallRealMethod();
        // stub
        long id = 1;

        when(albumCacheDao.get(id)).thenReturn(null);

        when(albumDao.get(id)).thenReturn(null);

        Album a = albumService.get(id);
        assertEquals(null, a);

        verify(albumCacheDao, times(1)).get(id);
        verify(albumDao, times(1)).get(id);
    }
}
