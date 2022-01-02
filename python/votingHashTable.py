voted = {}
def check_voter(name):
    if voted.get(name):
        print ('kick {} out'.format(name))
    else:
        voted[name] = True
        print ('let {} vote'.format(name))

check_voter("tom")
check_voter("alice")
check_voter("tom")