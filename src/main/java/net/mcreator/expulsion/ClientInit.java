/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.mcreator.expulsion;

import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.mcreator.expulsion.init.ExpulsionModBlocks;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
	public static final ManagedShaderEffect INDIGO_SHIFT = ShaderEffectManager.getInstance()
			.manage(new Identifier("expulsion", "shaders/post/blue_tint.json"));
	public static int snoofcount =0;
	public static boolean shaderActive = false;
	public static boolean shaderActive2 = false;
	public static final float colourspeed = 0.01f;
	public static float red = 0.0f;
	public static float green = 0.0f;
	public static float blue = 0.0f;
	public static float targetred = 1.0f;
	public  static float targetgreen = 1.0f;
	public static float targetblue = 1.0f;
	// Timer for shader duration
	private static long shaderStartTime = 0; // Time when shader was activated
	private static final long SHADER_DURATION = 300000; // 5 minutes in milliseconds
	private static final long SHADER_FADE_DURATION = SHADER_DURATION + 2000; // 1 second in milliseconds
	public static void indigoshader(){
		shaderStartTime = System.currentTimeMillis();
		if (!shaderActive) {
			shaderActive = true;

		}
		else {

			if (snoofcount ==2){
				targetred = 0.9f;
				targetgreen = 0.9f;
				targetblue = 1.0f;

			}
			if (snoofcount ==4){
				targetred = 0.85f;
				targetgreen = 0.85f;
				targetblue = 1.0f;
			}
			if (snoofcount ==6){
				targetred = 0.7f;
				targetgreen = 0.7f;
				targetblue = 1.0f;
			}
			if (snoofcount ==8){
				targetred = 0.55f;
				targetgreen = 0.55f;
				targetblue = 1.0f;
			}
			if (snoofcount ==10){
				targetred = 0.35f;
				targetgreen = 0.35f;
				targetblue = 1.0f;
			}
			if (snoofcount ==12){
				targetred = 0.2f;
				targetgreen = 0.2f;
				targetblue = 1.0f;
			}


			snoofcount++;
		}

	}
	@Override
	public void onInitializeClient() {
		ShaderEffectRenderCallback.EVENT.register(tickDelta -> {
			if (shaderActive) {
				long currentTime = System.currentTimeMillis();
				long elapsedTime = currentTime - shaderStartTime;
				if (elapsedTime > SHADER_DURATION) {
					// Begin fade-out process
					targetred = 0.90f;
					targetgreen = 0.90f;
					targetblue = 0.90f;

					// Reset snoofcount when effect duration ends
					snoofcount = 0;
				}

				// If fading is complete, deactivate the shader
				if (elapsedTime > SHADER_FADE_DURATION) {
					shaderActive = false;
					red = green = blue = 0.0f; // Ensure colors are fully reset
					return; // Stop further rendering
				}

				// Interpolate colors towards the target values
				red += (targetred - red) * colourspeed;
				green += (targetgreen - green) * colourspeed;
				blue += (targetblue - blue) * colourspeed;

				// Update the shader with the interpolated color values
				INDIGO_SHIFT.setUniformValue("ColorScale", red, green, blue);
				INDIGO_SHIFT.render(tickDelta);
			}
		});
		ExpulsionModBlocks.clientLoad();
	}
}
