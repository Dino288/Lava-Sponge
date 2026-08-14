from PIL import Image

img = Image.open('src/main/resources/assets/lavasponge/textures/block/lava_sponge.png')
new_img = Image.new('RGBA', (256, 255), (255, 255, 255, 255))
resized = img.resize((200, 200), Image.LANCZOS)
new_img.paste(resized, (28, 28), resized if img.mode == 'RGBA' else None)
new_img.save('curseforge_icon.png')
print("Icon created!")