package br.com.jgsi.celulamda.infra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.jgsi.celulamda.model.Celula;

/**
 * Created by guilhermewesley on 16/05/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "celulaMDA";

    private Dao<Celula, Long> celulaDAO = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Celula.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Celula.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Celula, Long> getCelulaDAO() {
        if(celulaDAO == null){
            try {
                celulaDAO = getDao(Celula.class);
            } catch (SQLException e) {
                e.printStackTrace();
                Log.e(DatabaseHelper.class.getName(), "Falha ao criar o dao CelulaDAO.", e);
            }
        }
        return  celulaDAO;
    }

    @Override
    public void close() {
        super.close();
        celulaDAO = null;
    }
}
