package cookie.tropicraft.compat.terrainapi;

import cookie.tropicraft.Tropicraft;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {

	@Override
	public String getModID() {
		return Tropicraft.MOD_ID;
	}

	@Override
	public void onInitialize() {
		new OverworldInitialization().init();
		new TropicsInitialization().init();
	}
}
