package com.logicalfallacy.shooter00;

import java.lang.Math;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.assets.*;

public class OneUpPowerup extends Powerup
{	
	public OneUpPowerup(float x, float y, AssetManager assetManager) {
		_texture = assetManager.get("data/1up_powerup.png", Texture.class);
		_sprite = new Sprite(_texture);
		_sprite.setOrigin(_sprite.getWidth()/2, _sprite.getHeight()/2);
		_sprite.setPosition(x, y);
		_sprite.setScale(0.1f*Gdx.graphics.getWidth()/_sprite.getWidth());

		_dxdy = new Vector2();
		_dest = new Vector2();
		_dest.x = (Math.random() - .5f > 0) ? -1f : Gdx.graphics.getWidth() +1f;
		_dest.y = (float)Math.random() * Gdx.graphics.getHeight()/2f;
		_speed = 0.125f * Gdx.graphics.getHeight();
		
		_onScreen = 20f;
		_expired = false;
		_timer.schedule(new Timer.Task(){
				@Override
				public void run() {
					_expired = true;
				} // end run()
			}, _onScreen);
			
		_applyToWingman = false;
		_dropOdds = .3f;
	}

	@Override
	public void activate()
	{
		_deleteMe = true;
	}
	
	

	@Override
	public void applyPickup(Player player)
	{
		// TODO: Implement this method
		player.addLife();
	}
	
}
