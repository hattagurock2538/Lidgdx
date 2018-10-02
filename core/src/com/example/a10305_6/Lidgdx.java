package com.example.a10305_6;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Lidgdx extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Music musicBackbround;
	private com.badlogic.gdx.math.Rectangle pigRectangle;
	private OrthographicCamera orthographicCamery;
	private Vector3 objVertor3;
	//private com.badlogic.gdx.utils.Array objCoinsDrop;
	private com.badlogic.gdx.utils.Array objCoinsDrop;
	private long lastDropTime;
	private Iterator<com.badlogic.gdx.math.Rectangle> objIterator;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		img = new Texture("pig.png");

		orthographicCamery = new OrthographicCamera();
		orthographicCamery.setToOrtho(false, 1500, 1000);

		pigRectangle = new com.badlogic.gdx.math.Rectangle();
		pigRectangle.x = 500;
		pigRectangle.y = 10;
		pigRectangle.width = 10;
		pigRectangle.height = 10;

		musicBackbround = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		musicBackbround.setLooping(true);
		musicBackbround.play();

		objCoinsDrop = new com.badlogic.gdx.utils.Array();
		gameCoinsDrop();

		musicBackbround = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"))
	}

	private void gameCoinsDrop() {
		coinsRectangel =
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		orthographicCamery.update();

		batch.setProjectionMatrix(orthographicCamery.combined);

		batch.begin();
		batch.draw(img, pigRectangle.x, pigRectangle.y);
		batch.end();

		if (Gdx.input.isTouched()){
			objVertor3 = new Vector3();
			objVertor3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			orthographicCamery.unproject(objVertor3);
			pigRectangle.x = objVertor3.x - 32;
		}

		if (pigRectangle.x < 0){
			pigRectangle.x = 0;
		}

		if (pigRectangle.x > 736){
			pigRectangle.x = 736;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
